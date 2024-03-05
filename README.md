# Coding challenge for "Naiz fit"

## Requirements

- Java >= 17

## Swagger documentation for both applications

http://instance/webjars/swagger-ui/index.html

### Examples of post bodies

Tester body
```json
{
  "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
  "name": "tester",
  "email": "tester@naiz.fit",
  "password": "tester",
  "birthdate": "2024-03-05",
  "sex": "MALE",
  "measures": [
    {
      "id": "3f285f64-5717-4562-b3fc-2c963f66afa6",
      "height": 234.5,
      "weight": 76.5
    },
    {
      "id": "3f185f64-5717-4562-b3fc-2c963f66afa6",
      "height": 234.5,
      "weight": 76.5
    }
  ]
}
```
Product body
```json
{
  "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
  "sku": "sku",
  "sizes": [
    "M","L","XS","S","XL","XXL"
  ],
  "pictures": [
    "https://google.com"
  ],
  "color": "Red",
  "brand": {
    "id": "3fa85f64-5717-4562-b3fc-2c123466afa6",
    "name": "brand",
    "logo": "https://google.com"
  }
}
```

### Pending

- Documentation
- Update test needs to update tester dones
- Dockerization
- Testing
- Read and Update
- Domain events
- Optimization based in AOT, GraalVM needed. [More info](
  https://docs.spring.io/spring-boot/docs/current/reference/html/native-image.html)

