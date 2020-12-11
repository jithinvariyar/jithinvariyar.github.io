module com.jithin.db {
    exports com.jithin.db;
    requires java.sql;
    requires sqlite.jdbc;
    requires transitive com.jithin.common;
}