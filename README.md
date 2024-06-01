# DATABASE-Service

**Database-service** - это мини-web приложение с регистрацией и авторизацией пользователя.

## Функциональность

- Регистрация пользователей
- Авторизация пользователей

## Запуск

- Вам нужно создать в БД(PostgreSQL) таблицу Person ,конфигурацию можно взять из файла "DataBaseconfig".
- Делать запросы можно через Postman.



## API Endpoints
- `POST /auth/signup`: Регистрация нового пользователя.
```json
{
  "username": "username",
  "email": "email@mail.ru",
  "password": "password"
}
```
- `POST /auth/signin`: Авторизация пользователя.
```json
{
  "username": "username",
  "password": "password"
}
```

- `GET /user/info`: Получение информации о пользователе.
- `GET /user/getId`: Получение Id пользователя.
- `GET /admin/all`: Получение всех зарегистрированных пользователей.



## Связаться со мной
- telegram:[@dvi_zhenya](https://t.me/dvi_zhenya)
- zhenya_nikolaev_1995@list.ru
