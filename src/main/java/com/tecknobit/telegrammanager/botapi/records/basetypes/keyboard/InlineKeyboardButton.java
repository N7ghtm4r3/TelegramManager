package com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard;

import com.tecknobit.apimanager.annotations.Returner;
import com.tecknobit.telegrammanager.botapi.records.basetypes.LoginUrl;
import com.tecknobit.telegrammanager.botapi.records.basetypes.chat.attachments.CallbackGame;
import com.tecknobit.telegrammanager.botapi.records.basetypes.webapp.WebAppInfo;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class InlineKeyboardButton extends TelegramType {

    private final String text;

    private final String url;

    private final String callbackData;

    private final WebAppInfo webApp;

    private final LoginUrl loginUrl;

    private final String switchInlineQuery;

    private final String switchInlineQueryCurrentChat;

    private final SwitchInlineQueryChosenChat switchInlineQueryChosenChat;

    private final CallbackGame callbackGame;

    private final boolean pay;

    public InlineKeyboardButton(String text, String url, String callbackData, WebAppInfo webApp, LoginUrl loginUrl,
                                String switchInlineQuery, String switchInlineQueryCurrentChat,
                                SwitchInlineQueryChosenChat switchInlineQueryChosenChat, CallbackGame callbackGame,
                                boolean pay) {
        super(null);
        this.text = text;
        this.url = url;
        this.callbackData = callbackData;
        this.webApp = webApp;
        this.loginUrl = loginUrl;
        this.switchInlineQuery = switchInlineQuery;
        this.switchInlineQueryCurrentChat = switchInlineQueryCurrentChat;
        this.switchInlineQueryChosenChat = switchInlineQueryChosenChat;
        this.callbackGame = callbackGame;
        this.pay = pay;
    }

    public InlineKeyboardButton(JSONObject jInlineKeyboardButton) {
        super(jInlineKeyboardButton);
        text = hTelegram.getString("text");
        url = hTelegram.getString("url");
        callbackData = hTelegram.getString("callback_data");
        webApp = WebAppInfo.getInstance(hTelegram.getJSONObject("web_app"));
        loginUrl = LoginUrl.getInstance(hTelegram.getJSONObject("login_url"));
        switchInlineQuery = hTelegram.getString("switch_inline_query");
        switchInlineQueryCurrentChat = hTelegram.getString("switch_inline_query_current_chat");
        switchInlineQueryChosenChat = SwitchInlineQueryChosenChat
                .getInstance(hTelegram.getJSONObject("switch_inline_query_chosen_chat"));
        callbackGame = CallbackGame.getInstance(hTelegram.getJSONObject("callback_game"));
        pay = hTelegram.getBoolean("pay");
    }

    public String getText() {
        return text;
    }

    public String getUrl() {
        return url;
    }

    public String getCallbackData() {
        return callbackData;
    }

    public WebAppInfo getWebApp() {
        return webApp;
    }

    public LoginUrl getLoginUrl() {
        return loginUrl;
    }

    public String getSwitchInlineQuery() {
        return switchInlineQuery;
    }

    public String getSwitchInlineQueryCurrentChat() {
        return switchInlineQueryCurrentChat;
    }

    public SwitchInlineQueryChosenChat getSwitchInlineQueryChosenChat() {
        return switchInlineQueryChosenChat;
    }

    public CallbackGame getCallbackGame() {
        return callbackGame;
    }

    public boolean isPay() {
        return pay;
    }

    /**
     * Method to return a {@link InlineKeyboardButton} list
     *
     * @param jInlineKeyboardButtons : JSON source from fetch the list
     * @return inline keyboard buttons list as {@link ArrayList} of {@link InlineKeyboardButton}
     */
    @Returner
    public static ArrayList<InlineKeyboardButton> returnInlineKeyboardButtons(JSONArray jInlineKeyboardButtons) {
        ArrayList<InlineKeyboardButton> inlineKeyboardButtons = new ArrayList<>();
        if (jInlineKeyboardButtons != null)
            for (int j = 0; j < jInlineKeyboardButtons.length(); j++)
                inlineKeyboardButtons.add(new InlineKeyboardButton(jInlineKeyboardButtons.getJSONObject(j)));
        return inlineKeyboardButtons;
    }

    public static InlineKeyboardButton getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new InlineKeyboardButton(jItem);
    }

}
