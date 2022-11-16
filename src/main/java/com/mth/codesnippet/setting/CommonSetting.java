package com.mth.codesnippet.setting;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author 木土禾
 * Created on 2022/11/16 18:40:52
 */
@State(
        name = "com.mth.codesnippet.setting.CommonSetting",
        storages = @Storage("CodeSnippetPlugin.xml")
)
public class CommonSetting implements PersistentStateComponent<CommonSetting> {

    public String yuQueToken = "";
    public String yuQueRepo = "";

    public String getYuQueToken() {
        return yuQueToken;
    }

    public CommonSetting setYuQueToken(String yuQueToken) {
        this.yuQueToken = yuQueToken;
        return this;
    }

    public String getYuQueRepo() {
        return yuQueRepo;
    }

    public CommonSetting setYuQueRepo(String yuQueRepo) {
        this.yuQueRepo = yuQueRepo;
        return this;
    }

    public static CommonSetting getInstance() {
        return ApplicationManager.getApplication().getService(CommonSetting.class);
    }

    @Override
    public @Nullable CommonSetting getState() {
        return this;
    }

    @Override
    public void loadState(@NotNull CommonSetting state) {
        XmlSerializerUtil.copyBean(state, this);
    }
}
