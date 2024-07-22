docker-compose up -d

This command will start three Redis nodes.

# Initialize the Redis Cluster
### To initialize the Redis cluster, you need to create the cluster from one of the Redis nodes. You can use the redis-cli tool inside one of the Redis containers to do this.

Run the following command to get a shell into one of the Redis nodes:
docker exec -it <container_id> sh
Replace <container_id> with the container ID of one of the Redis nodes, e.g., redis-node-1.

Once inside the container, run the following command to create the cluster:

redis-cli --cluster create 172.28.0.2:6379 172.28.0.3:6379 172.28.0.4:6379 --cluster-replicas 0

### Verify the Cluster
You can verify that the cluster is set up correctly by running the following command from inside any of the Redis nodes:

redis-cli -c -h 172.28.0.2 -p 6379 cluster nodes

This command will list the nodes in the cluster and their roles.