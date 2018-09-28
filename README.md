# spring-boot-mongo-graphql

GraphQL starter with spring-boot and spring-data-mongo

Run the app by `mvn spring-boot:run` or simply run the Application.java from your IDE.
Bring up http://localhost:9000/graphiql to use the graphiql tool.

Request:
```
query {
    recentPosts(count: 10, offset: 0) {
       permalink
    	 author
    	 id
    }
}
```
Response:
```
{
  "data": {
    "recentPosts": [
      {
        "permalink": "cxzdzjkztkqraoqlgcru",
        "author": "machine",
        "id": "5143ddf3bcf1bf4ab37d9c6d"
      },
      ...
}
```
