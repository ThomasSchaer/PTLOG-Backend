# PTLOG Backend

## Description
PTlog backend implemented using springboot and in-memory database

## Dependencies
```httpie: python needs to be installed```

## How to launch
```.\gradlew bootrun```

## How to create and exercise
```http POST :8080/exercises < httpiefile.json```

## How to list all exerises
```http :8080/exercises```

## How to list one exercise
```http :8080/exercises/1```

## How to update one exercise
```http PUT :8080/exercises < httpiefile.json```

## How to delete one exercise
```http DELETE :8080/exercises/1```

## Notes
```https://github.com/tonsV2/Lift-Log-Backend/blob/master/README.md```
