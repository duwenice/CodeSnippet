package com.mth.codesnippet.setting;

import com.intellij.ui.components.JBLabel;
import com.intellij.ui.components.JBTextField;
import com.intellij.util.ui.FormBuilder;

import javax.swing.*;

/**
 * @author 木土禾
 * Created on 2022/11/16 18:45:06
 */
public class CommonSettingComponent {

    private final JPanel yuQuePanel;
    private final JBTextField yuQueToken = new JBTextField();
    private final JBTextField yuQueRepo = new JBTextField();

    public CommonSettingComponent() {
        yuQuePanel = FormBuilder.createFormBuilder()
                .addLabeledComponent(new JBLabel("输入语雀的TOKEN: "), yuQueToken, 1, false)
                .addLabeledComponent(new JBLabel("输入语雀的知识库路径: "), yuQueRepo, 1, false)
                .addComponentFillVertically(new JPanel(), 0)
                .getPanel();
    }


    public JPanel getPanel() {
        return yuQuePanel;
    }

    public String getYuQueToken() {
        return yuQueToken.getText();
    }

    public String getYuQueRepo() {
        return yuQueRepo.getText();
    }

    public JComponent getPreferredFocusedComponent() {
        return yuQueToken;
    }

    public void setYuQueRepo(String newText) {
        yuQueRepo.setText(newText);
    }


    public void setYuQueToken(String newText) {
        yuQueToken.setText(newText);
    }
}
