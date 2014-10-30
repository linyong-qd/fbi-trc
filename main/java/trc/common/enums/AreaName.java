package trc.common.enums;

import java.util.Hashtable;

/**
 * ���˽��
 */
public enum AreaName implements EnumApp {
    LEFT("01", "����ɷ�"),
    EDUCATION("02", "����������"),
    FINANCE("03","���������"),
    ORGANIZACTION("04","������֧��������"),
    OTHER("99","����");

    private String code = null;
    private String title = null;
    private static Hashtable<String, AreaName> aliasEnums;

    AreaName(String code, String title) {
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

    public static AreaName valueOfAlias(String alias) {
        return aliasEnums.get(alias);
    }

    public String getCode() {
        return this.code;
    }

    public String getTitle() {
        return this.title;
    }
}
