// db.getSiblingDB() : used to return another database without modifying the db variable in the shell environment.
// You can use db.getSiblingDB() as an alternative to the use <database> helper.
// This is particularly useful when writing scripts using mongosh where the use helper is not available.
// Ref.: https://www.mongodb.com/docs/manual/reference/method/db.getSiblingDB/
db = db.getSiblingDB("network")

// Insert a log trace
db.log.insertOne({"message": "Switched to network Database."});

// Collection created
db.createCollection("node")

// Insert a log trace
db.log.insertOne({"message": "Collection node created."});

// Create a user for the database above.
db.createUser(
        {
            user: "network-graph",
            pwd: "graph",
            roles: [
                {
                    role: "readWrite",
                    db: "network"
                }
            ]
        }
);