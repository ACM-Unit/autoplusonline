package ua.com.autoplus.dbTools;

import org.hibernate.dialect.MySQL8Dialect;

public class AutoPlusSQLDialect extends MySQL8Dialect {
    public AutoPlusSQLDialect() {
        super();
        registerFunction("MatchAgainst", new MatchAgainst());
    }
}
