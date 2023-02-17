<p align="center">
<img src="https://raw.githubusercontent.com/wiki/lyes-s/multi-element-relationally-interconnected-topology/images/phoenix.png" width="30%">
</p>
<h1 align="center">M.E.R.I.T<br/>
  Multi-Element Relationally Interconnected Topology</br>
</h1>

# MIT License

[Copyright (c) 2023 Lyes Sefiane.](https://github.com/lyes-s/multi-element-relationally-interconnected-topology/blob/main/LICENSE.md)

# GitHub Badges

![GitHub top language](https://img.shields.io/github/languages/top/lyes-s/multi-element-relationally-interconnected-topology)
![GitHub Repo stars](https://img.shields.io/github/stars/lyes-s/multi-element-relationally-interconnected-topology?style=social)
[![license](https://img.shields.io/badge/License-MIT-yellow.svg)](https://github.com/lyes-s/multi-element-relationally-interconnected-topology/blob/main/LICENSE.md)

# Architecture

<p align="center">
<img src="https://raw.githubusercontent.com/wiki/lyes-s/multi-element-relationally-interconnected-topology/images/The-MERIT-v8.PNG" width="100%">
</p>

# User Interface

> URL : http://localhost:4200

## Index

<p align="center">
<img src="https://raw.githubusercontent.com/wiki/lyes-s/multi-element-relationally-interconnected-topology/images/index-v2.PNG" width="100%">
</p>

## Network Elements

### Retrieve All Network Elements

<p align="center">
<img src="https://raw.githubusercontent.com/wiki/lyes-s/multi-element-relationally-interconnected-topology/images/network-elements-v2.PNG" width="100%">
</p>

### Edit a Network Element

<p align="center">
<img src="https://raw.githubusercontent.com/wiki/lyes-s/multi-element-relationally-interconnected-topology/images/edit-network-elements-v2.PNG" width="100%">
</p>

## Network Graph

<p align="center">
<img src="https://raw.githubusercontent.com/wiki/lyes-s/multi-element-relationally-interconnected-topology/images/network-graph.PNG" width="100%">
</p>


# Wiki

* [M.E.R.I.T : The Multi-Element Relationally Interconnected Topology Wiki !](https://github.com/lyes-s/multi-element-relationally-interconnected-topology/wiki)

# OpenAPI/Swagger

> Network Elements : https://app.swaggerhub.com/apis-docs/lye-s/network-elements/1.0

> Network Graph : https://app.swaggerhub.com/apis-docs/lye-s/network-graph/1.0


# Requirements
```
1. Java 11.x.y

2. Maven 3.x.y

3. Docker 3.x.y
```

# Git Clone

```java
git clone https://github.com/lyes-s/multi-element-relationally-interconnected-topology.git
```

# M.E.R.I.T : The Script

```java
mitsuke ( ◥◣_◢◤ ) : ~$ cd multi-element-relationally-interconnected-topology/

mitsuke ( ◥◣_◢◤ ) : ~$ chmod +x the-merit-script

mitsuke ( ◥◣_◢◤ ) : ~$ ./the-merit-script


     ████████╗██╗  ██╗███████╗    ███╗   ███╗   ███████╗   ██████╗    ██╗████████╗
     ╚══██╔══╝██║  ██║██╔════╝    ████╗ ████║   ██╔════╝   ██╔══██╗   ██║╚══██╔══╝
        ██║   ███████║█████╗      ██╔████╔██║   █████╗     ██████╔╝   ██║   ██║
        ██║   ██╔══██║██╔══╝      ██║╚██╔╝██║   ██╔══╝     ██╔══██╗   ██║   ██║
        ██║   ██║  ██║███████╗    ██║ ╚═╝ ██║██╗███████╗██╗██║  ██║██╗██║██╗██║
        ╚═╝   ╚═╝  ╚═╝╚══════╝    ╚═╝     ╚═╝╚═╝╚══════╝╚═╝╚═╝  ╚═╝╚═╝╚═╝╚═╝╚═╝

        mitsuke ( ◥◣_◢◤ ) : Hi 😊 ! please make a selection.

        1) Docker Compose Up
        2) Docker Compose Down
        3) quit
        #? 1
        Docker Compose Up ...
        Creating network "docker-compose_network-elements" with the default driver
        Creating network "docker-compose_redis" with the default driver
        Creating network "docker-compose_network-graph" with the default driver
        Creating network "docker-compose_consul" with the default driver
        Creating network "docker-compose_kafka" with the default driver
        Creating network "docker-compose_schema-registry" with the default driver
        Creating network "docker-compose_gateway" with the default driver
        Creating network "docker-compose_ui" with the default driver
        Creating volume "docker-compose_redis-cluster_data-0" with default driver
        Creating volume "docker-compose_redis-cluster_data-1" with default driver
        Creating volume "docker-compose_redis-cluster_data-2" with default driver
        Creating volume "docker-compose_redis-cluster_data-3" with default driver
        Creating volume "docker-compose_redis-cluster_data-4" with default driver
        Creating volume "docker-compose_redis-cluster_data-5" with default driver
        Creating volume "docker-compose_pgdata" with default driver
        Creating volume "docker-compose_mongodb-data" with default driver
        Creating network-elements-db ... done
        Creating zookeeper           ... done
        Creating redis-node-4        ... done
        Creating mongodb             ... done
        Creating consul-server       ... done
        Creating redis-node-3        ... done
        Creating redis-node-0        ... done
        Creating redis-node-2        ... done
        Creating redis-node-1        ... done
        Creating flyway              ... done
        Creating mongo-express       ... done
        Creating kafka3              ... done
        Creating kafka2              ... done
        Creating consul-client       ... done
        Creating kafka1              ... done
        Creating redis-node-5        ... done
        Creating kafdrop             ... done
        Creating schema-registry     ... done
        Creating network-graph       ... done
        Creating network-elements    ... done
        Creating api-gateway         ... done
        Creating network-ui          ... done
```

# API

## Network Element

```java
curl -H 'Content-Type: application/json' http://localhost:8080/api/v1/devices

[
    {
        "address": "10.133.13.12",
        "elementType": "router",
        "area": 0,
        "neighbors": [
            {
                "address": "10.133.13.13",
                "cost": 2
            },
            {
                "address": "10.133.13.14",
                "cost": 3
            },
            {
                "address": "10.133.13.15",
                "cost": 1
            }
        ],
        "edges": [
            {
                "rel": "self",
                "href": "http://8e5eace76bac:8080/api/v1/devices/10.133.13.12"
            }
        ]
    },
    {
        "address": "10.133.13.13",
        "elementType": "server",
        "area": 0,
        "neighbors": [],
        "edges": [
            {
                "rel": "self",
                "href": "http://8e5eace76bac:8080/api/v1/devices/10.133.13.13"
            }
        ]
    },
    {
        "address": "10.133.13.14",
        "elementType": "wireless router",
        "area": 0,
        "neighbors": [
            {
                "address": "10.133.13.16",
                "cost": 5
            }
        ],
        "edges": [
            {
                "rel": "self",
                "href": "http://8e5eace76bac:8080/api/v1/devices/10.133.13.14"
            }
        ]
    },
    {
        "address": "10.133.13.15",
        "elementType": "switch",
        "area": 0,
        "neighbors": [
            {
                "address": "10.133.13.17",
                "cost": 4
            },
            {
                "address": "10.133.13.18",
                "cost": 4
            },
            {
                "address": "10.133.13.19",
                "cost": 4
            }
        ],
        "edges": [
            {
                "rel": "self",
                "href": "http://8e5eace76bac:8080/api/v1/devices/10.133.13.15"
            }
        ]
    },
    {
        "address": "10.133.13.16",
        "elementType": "laptop",
        "area": 0,
        "neighbors": [],
        "edges": [
            {
                "rel": "self",
                "href": "http://8e5eace76bac:8080/api/v1/devices/10.133.13.16"
            }
        ]
    },
    {
        "address": "10.133.13.17",
        "elementType": "desktop computer",
        "area": 0,
        "neighbors": [
            {
                "address": "10.133.13.18",
                "cost": 0
            },
            {
                "address": "10.133.13.19",
                "cost": 0
            }
        ],
        "edges": [
            {
                "rel": "self",
                "href": "http://8e5eace76bac:8080/api/v1/devices/10.133.13.17"
            }
        ]
    },
    {
        "address": "10.133.13.18",
        "elementType": "desktop computer",
        "area": 0,
        "neighbors": [
            {
                "address": "10.133.13.19",
                "cost": 0
            }
        ],
        "edges": [
            {
                "rel": "self",
                "href": "http://8e5eace76bac:8080/api/v1/devices/10.133.13.18"
            }
        ]
    },
    {
        "address": "10.133.13.19",
        "elementType": "desktop computer",
        "area": 0,
        "neighbors": [],
        "edges": [
            {
                "rel": "self",
                "href": "http://8e5eace76bac:8080/api/v1/devices/10.133.13.19"
            }
        ]
    }
]
```

## Network Graph

```java
curl -X POST -H 'Content-Type: application/json' http://localhost:8080/api/graphql -d '{ "query": "{ retrieveGraph { nodes { id area elementType} links { source target cost} } }" }'

{
   "data": {
      "retrieveGraph": {
          "nodes": [
            {
                "id": "10.133.13.12",
                "area": 0,
                "elementType": "router"
            },
            {
                "id": "10.133.13.13",
                "area": 0,
                "elementType": "server"
            },
            {
                "id": "10.133.13.14",
                "area": 0,
                "elementType": "wireless router"
            },
            {
                "id": "10.133.13.15",
                "area": 0,
                "elementType": "switch"
            },
            {
                "id": "10.133.13.16",
                "area": 0,
                "elementType": "laptop"
            },
            {
                "id": "10.133.13.17",
                "area": 0,
                "elementType": "desktop computer"
            },
            {
                "id": "10.133.13.18",
                "area": 0,
                "elementType": "desktop computer"
            },
            {
                "id": "10.133.13.19",
                "area": 0,
                "elementType": "desktop computer"
            }
        ],
        "links": [
            {
                "source": "10.133.13.15",
                "target": "10.133.13.17",
                "cost": 4
            },
            {
                "source": "10.133.13.12",
                "target": "10.133.13.14",
                "cost": 3
            },
            {
                "source": "10.133.13.12",
                "target": "10.133.13.13",
                "cost": 2
            },
            {
                "source": "10.133.13.15",
                "target": "10.133.13.18",
                "cost": 4
            },
            {
                "source": "10.133.13.14",
                "target": "10.133.13.16",
                "cost": 5
            },
            {
                "source": "10.133.13.12",
                "target": "10.133.13.15",
                "cost": 1
            },
            {
                "source": "10.133.13.17",
                "target": "10.133.13.19",
                "cost": 0
            },
            {
                "source": "10.133.13.15",
                "target": "10.133.13.19",
                "cost": 4
            },
            {
                "source": "10.133.13.17",
                "target": "10.133.13.18",
                "cost": 0
            },
            {
                "source": "10.133.13.18",
                "target": "10.133.13.19",
                "cost": 0
            }
        ]
      }
   }
}
```

# Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.
