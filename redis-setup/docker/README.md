docker run -d --name redis -p 6379:6379 redis:6.2.6


docker run -d --name redis -p 6379:6379 -v /c/Users/amsid/redis-data:/data redis:6.2.6 redis-server --appendonly yes

