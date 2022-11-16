package com.mth.codesnippet.dialog;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.psi.PsiFile;
import com.intellij.ui.EditorTextField;
import com.mth.codesnippet.markdown.MarkdownGenerator;
import com.mth.codesnippet.markdown.MarkdownParagraphDTO;
import com.mth.codesnippet.setting.CommonSetting;
import com.mth.codesnippet.utils.NotifyUtils;
import com.mth.codesnippet.yuque.YuQueConfigDTO;
import com.mth.codesnippet.yuque.YuQueInstance;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;

/**
 * @author 木土禾
 * Created on 2022/11/13 14:04:08
 */
public class NoteDialog extends DialogWrapper {

    private final String selectCodeSnippet;

    private final Project project;

    private final PsiFile psiFile;

    private final EditorTextField editorTextField = new EditorTextField();


    public NoteDialog(Project project, PsiFile psiFile, String selectCodeSnippet) {
        super(true);
        this.project = project;
        this.psiFile = psiFile;
        this.selectCodeSnippet = selectCodeSnippet;
        setTitle("添加备注");
        init();
    }

    @Override
    protected @Nullable JComponent createCenterPanel() {
        JPanel dialogPanel = new JPanel(new BorderLayout());
        dialogPanel.add(editorTextField, BorderLayout.CENTER);
        dialogPanel.setSize(100, 20);
        return dialogPanel;
    }

    @Override
    protected void doOKAction() {
        super.doOKAction();
        try {
            MarkdownParagraphDTO markdownParagraphDTO = new MarkdownParagraphDTO()
                    .setNote(editorTextField.getText())
                    .setCodeSnippet(selectCodeSnippet)
                    .setCodeType(psiFile.getFileType().getName());
            String md = MarkdownGenerator.generateMd(markdownParagraphDTO);
            YuQueConfigDTO yuQueConfigDTO = new YuQueConfigDTO();
            yuQueConfigDTO.setRepo(CommonSetting.getInstance().getYuQueRepo());
            yuQueConfigDTO.setToken(CommonSetting.getInstance().getYuQueToken());
            YuQueInstance yuQueInstance = new YuQueInstance(yuQueConfigDTO, project);
            yuQueInstance.upsertDoc(md);
        } catch (Exception e) {
            NotifyUtils.sendErrorMsg(project, e.getMessage());
        }
    }
}
