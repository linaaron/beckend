package com.self.groupcache;

import org.springframework.beans.factory.config.AbstractFactoryBean;

public class GroupCacheFactoryBean extends AbstractFactoryBean<GroupCache> {
    private CacheConfiguration config = new CacheConfiguration();

    private GroupCache groupCache;

    @Override
    public Class<?> getObjectType() {
        return GroupCache.class;
    }

    @Override
    protected GroupCache createInstance() throws Exception {
        GroupCacheBuilder groupCacheBuilder = new GroupCacheBuilder();
//        groupCache = groupCacheBuilder.
        return groupCache;
    }

    public void destroy() {
        if (this.groupCache != null) {
            this.groupCache.shutdown();
        }
    }
}
