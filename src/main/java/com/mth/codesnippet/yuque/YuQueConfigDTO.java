package com.mth.codesnippet.yuque;

import com.google.common.base.MoreObjects;

/**
 * @author 木土禾
 * Created on 2022/11/14 22:48:01
 */
public class YuQueConfigDTO {

    private String token;

    private String repo;

    public String getToken() {
        return token;
    }

    public YuQueConfigDTO setToken(String token) {
        this.token = token;
        return this;
    }

    public String getRepo() {
        return repo;
    }

    public YuQueConfigDTO setRepo(String repo) {
        this.repo = repo;
        return this;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("token", token)
                .add("repo", repo)
                .toString();
    }
}
