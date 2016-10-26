package cz.vsb.p4.testapp;

import com.google.common.collect.Maps;
import org.h2.jdbcx.JdbcDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.Map;

/**
 * Created by ruz76 on 26.10.2016.
 */
@Service
public class CounterDAO {

    private final JdbcDataSource dataSource;

    @Autowired
    public CounterDAO(@Value("${jdbc.connection}") String jdbcConnection,
                      @Value("${jdbc.name}") String jdbcName,
                      @Value("${jdbc.password}") String jdbcPassword) {
        this.dataSource = new JdbcDataSource();
        dataSource.setPassword(jdbcPassword);
        dataSource.setUser(jdbcName);
        dataSource.setUrl(jdbcConnection);
    }

    /**
     * Store key value to database
     *
     * @param key   key name
     * @param value key value
     */
    public void storeKeyValue(String key, long value) {

    }

    /**
     * Load all key values from database to memory
     *
     * @return map of key -> value
     */
    public Map<String, Long> loadKeyValues() {
        return Maps.newHashMap();
    }

}
