package gov.moandor.androidweibo.dao;

import gov.moandor.androidweibo.bean.WeiboUser;
import gov.moandor.androidweibo.util.HttpParams;
import gov.moandor.androidweibo.util.HttpUtils;
import gov.moandor.androidweibo.util.JsonUtils;
import gov.moandor.androidweibo.util.TextUtils;
import gov.moandor.androidweibo.util.UrlHelper;
import gov.moandor.androidweibo.util.WeiboException;

public class UserShowDao extends BaseHttpDao<WeiboUser> {
    private String mToken;
    private String mScreenName;
    private long mUid;

    @Override
    public WeiboUser execute() throws WeiboException {
        HttpParams params = new HttpParams();
        params.put("access_token", mToken);
        params.put("uid", mUid);
        params.put("screen_name", mScreenName);
        HttpUtils.Method method = HttpUtils.Method.GET;
        String response = HttpUtils.executeNormalTask(method, mUrl, params);
        return JsonUtils.getWeiboUserFromJson(response);
    }

    @Override
    protected String getUrl() {
        return UrlHelper.USERS_SHOW;
    }

    public void setToken(String token) {
        mToken = token;
    }

    public void setScreenName(String screenName) {
        mScreenName = screenName;
    }

    public void setUid(long uid) {
        mUid = uid;
    }
}
