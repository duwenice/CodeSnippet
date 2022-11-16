package com.mth.codesnippet.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFile;
import com.mth.codesnippet.dialog.CodeNoteDialog;
import com.mth.codesnippet.utils.NotifyUtils;

/**
 * @author 木土禾
 * Created on 2022/11/13 10:10:36
 */
public class SelectCodeSnippetAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        // 获取当前project对象
        Project project = e.getData(PlatformDataKeys.PROJECT);
        // 获取当前编辑的文件
        PsiFile psiFile = e.getData(CommonDataKeys.PSI_FILE);
        //获取当前编辑器对象
        Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);
        //获取选择的数据模型
        SelectionModel selectionModel = editor.getSelectionModel();
        //获取当前选择的文本
        String selectedText = selectionModel.getSelectedText();

        CodeNoteDialog noteDialog = new CodeNoteDialog(project, psiFile, selectedText);
        if (noteDialog.showAndGet()) {
            NotifyUtils.sendInfoMsg(project, "已上传到语雀");
        }
    }
}
