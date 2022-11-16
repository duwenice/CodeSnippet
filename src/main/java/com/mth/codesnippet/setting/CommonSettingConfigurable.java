package com.mth.codesnippet.setting;

import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.util.NlsContexts;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * @author 木土禾
 * Created on 2022/11/16 18:51:04
 */
public class CommonSettingConfigurable implements Configurable {

    private CommonSettingComponent commonSettingComponent;

    @Override
    public @NlsContexts.ConfigurableName String getDisplayName() {
        return "com.mth.codesnippet.setting.CommonSettingConfigurable";
    }

    @Override
    public @Nullable JComponent getPreferredFocusedComponent() {
        return commonSettingComponent.getPreferredFocusedComponent();
    }

    @Override
    public @Nullable JComponent createComponent() {
        commonSettingComponent = new CommonSettingComponent();
        return commonSettingComponent.getPanel();
    }

    @Override
    public boolean isModified() {
        return true;
    }

    @Override
    public void apply() throws ConfigurationException {
        CommonSetting settings = CommonSetting.getInstance();
        settings.setYuQueToken(commonSettingComponent.getYuQueToken());
        settings.setYuQueRepo(commonSettingComponent.getYuQueRepo());
    }

    @Override
    public void reset() {
        CommonSetting settings = CommonSetting.getInstance();
        commonSettingComponent.setYuQueToken(settings.getYuQueToken());
        commonSettingComponent.setYuQueRepo(settings.getYuQueRepo());
    }

    @Override
    public void disposeUIResources() {
        commonSettingComponent = null;
    }
}
