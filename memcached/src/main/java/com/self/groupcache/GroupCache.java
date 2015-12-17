package com.self.groupcache;

public interface GroupCache {
    void put(String key, Object value);

    Object get(String key);

    Object get(String key ,CacheLoader cacheLoader);

    Object get(String key , boolean refreshExpireTime);

    Object get(String key,  boolean refreshExpireTime, CacheLoader cacheLoader);

    Object getFromRemote(String key);

    Object getFromRemote(String key, boolean refreshExpireTime);

    Object getFromRemote(String key, CacheLoader cacheLoader);

    Object getFromRemote(String key, boolean refreshExpireTime, CacheLoader cacheLoader);

    boolean remove(String key);

    void shutdown();
}
