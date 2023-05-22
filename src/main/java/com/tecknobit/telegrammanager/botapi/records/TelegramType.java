package com.tecknobit.telegrammanager.botapi.records;

import com.tecknobit.apimanager.annotations.Structure;
import org.json.JSONObject;

@Structure
public abstract class TelegramType extends TelegramTypeStructure {

    protected final boolean ok;
    protected final int errorCode;
    protected final String description;
    protected final ResponseParameters parameters;

    public TelegramType(JSONObject jTelegramType) {
        super(jTelegramType);
        ok = hTelegram.getBoolean("ok");
        errorCode = hTelegram.getInt("error_code", -1);
        description = hTelegram.getString("description");
        JSONObject jParameters = hTelegram.getJSONObject("parameters");
        if (jParameters != null)
            parameters = new ResponseParameters(jParameters);
        else
            parameters = null;
        if (ok)
            hTelegram.setJSONObjectSource(jTelegramType.getJSONObject("result"));
    }

    public boolean isOk() {
        return ok;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getDescription() {
        return description;
    }

    public ResponseParameters getParameters() {
        return parameters;
    }

    public static class ResponseParameters extends TelegramTypeStructure {

        private final long migrateToChatId;
        private final long retryAfter;

        public ResponseParameters(long migrateToChatId, long retryAfter) {
            super(null);
            this.migrateToChatId = migrateToChatId;
            this.retryAfter = retryAfter;
        }

        public ResponseParameters(JSONObject jResponseParameters) {
            super(jResponseParameters);
            migrateToChatId = hTelegram.getLong("", -1);
            retryAfter = hTelegram.getLong("", -1);
        }

        public long getMigrateToChatId() {
            return migrateToChatId;
        }

        public long getRetryAfter() {
            return retryAfter;
        }

    }

}
