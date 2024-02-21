# Database creation

```
docker run -e POSTGRES_PASSWORD=chieftain -e POSTGRES_USER=chieftain -p 5432:5432 --name chieftain-db -d postgres