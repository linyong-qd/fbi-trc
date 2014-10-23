package trc.common.enums;

import java.util.Hashtable;

/**
 * ���˽��
 */
public enum AcctType implements EnumApp {
    MERCHANT("1", "�Թ��˺�"),
    PERSON("2", "��˽�˺�");

    private String code = null;
    private String title = null;
    private static Hashtable<String, AcctType> aliasEnums;

    AcctType(String code, String title) {
        this.init(code, title);
    }

    @SuppressWarnings("unchecked")
    private void init(String code, String title) {
        this.code = code;
        this.title = title;
        synchronized (this.getClass()) {
            if (aliasEnums == null) {
                aliasEnums = new Hashtable();
            }
        }
        aliasEnums.put(code, this);
        aliasEnums.put(title, this);
    }

    public static AcctType valueOfAlias(String alias) {
        return aliasEnums.get(alias);
    }

    public String getCode() {
        return this.code;
    }

    public String getTitle() {
        return this.title;
    }
}
