package com.adavari.shortener.service.impl

import com.adavari.shortener.service.CoordinationService
import org.apache.curator.framework.CuratorFramework
import org.apache.zookeeper.CreateMode
import org.apache.zookeeper.ZooDefs.Ids
import org.springframework.stereotype.Service

@Service
class ZookeeperCoordinationService(private val curatorFramework: CuratorFramework) : CoordinationService {

    companion object {
        private const val SEQUENCE_PATH = "/SEQUENCE"
        private const val BUCKET_SIZE = 50_000
    }

    override suspend fun getSequenceRange(): LongRange {
        val path = curatorFramework.zookeeperClient.zooKeeper.create(
            SEQUENCE_PATH, ByteArray(0),
            Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL)
        val start = path.replace(SEQUENCE_PATH, "").toLong() * BUCKET_SIZE
        return LongRange(start, start + (BUCKET_SIZE -1))
    }

}