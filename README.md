# fast-grill-url
### Setting
#### 1. docker compose 실행
```
cd docker
docker-compose up
```
#### 2. api 호출
```
curl -X GET "localhost:8080/api/RXad41E"
```

#### 3. kafka drop 확인하기 
http://localhost:9001/
![kafdrop-screenshot](./kafdrop-screenshot.png)


### Module
```mermaid
flowchart TB
    subgraph shorten-url-admin
    shorten-url-생성
    shorten-url-referer-url-조회
    shorten-url-click-통계-조회
    end
   subgraph shorten-url-api
    shorten-url-생성-->shorten-url-클릭
    shorten-url-클릭-->kafka-click-event-발행
    end
    subgraph shorten-url-subscriber
    kafka-click-event-발행-->kafka-click-event-구독
    kafka-click-event-구독-->click-log-mongo-db-집계
    kafka-click-event-구독-->click-action-통계-집계
    end
```

### Click Flow 
```mermaid
flowchart TD
    A[shorten-url-클릭] --> G{url이-활성화되었는가}
    G -->|NO| E[404-notfound]
    G{url이-활성화되었는가} --> |YES| B{ttl이-만료되었는가}
    B -->|Yes| D[404-notfound]
    B{ttl이-만료되었는가?} --> |NO| C{호출빈도-제한에-걸렸는가}
    C -->|Yes| D[404-notfound]
    C -->|NO| E[origin-url-redirect]
```
