package xyz.winthanhtike.travelandtour.db;

/**
 * Created by winthanhtike on 6/10/16.
 */
public class DataContract {

    public static final String DATABASE_NAME = "dotareview";
    public static final int DATABASE_VERSION = 1;

    public class StrengthTable {

        public static final String TABLE_NAME = "strength";
        public static final String HERO_ID = "s_id";
        public static final String HERO_NAME = "s_name";
        public static final String HERO_URL = "s_image";
        public static final String HERO_DESC = "s_overview";
        public static final String HERO_ROLE = "role";
        public static final String HERO_HISTORY = "s_detail";

    }

    public class AgilityTable {

        public static final String TABLE_NAME = "agility";
        public static final String HERO_ID = "a_id";
        public static final String HERO_NAME = "a_name";
        public static final String HERO_URL = "a_image";
        public static final String HERO_DESC = "a_overview";
        public static final String HERO_ROLE = "role";
        public static final String HERO_HISTORY = "a_detail";

    }

    public class IntelligenceTable {

        public static final String TABLE_NAME = "intelligence";
        public static final String HERO_ID = "i_id";
        public static final String HERO_NAME = "i_name";
        public static final String HERO_URL = "i_image";
        public static final String HERO_DESC = "i_overview";
        public static final String HERO_ROLE = "role";
        public static final String HERO_HISTORY = "i_detail";

    }

}
