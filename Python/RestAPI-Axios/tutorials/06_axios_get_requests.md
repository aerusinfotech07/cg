# Axios GET Requests

## GET – List All

```javascript
const response = await axios.get('http://127.0.0.1:8000/items');
const items = response.data.items;
```

## GET – By ID

```javascript
const id = 1;
const response = await axios.get(`http://127.0.0.1:8000/items/${id}`);
const item = response.data;
```

## Query Parameters

```javascript
const response = await axios.get('http://127.0.0.1:8000/items', {
  params: { skip: 0, limit: 10 }
});
```

## Default Base URL

```javascript
const api = axios.create({
  baseURL: 'http://127.0.0.1:8000'
});
const response = await api.get('/items');
```

## Next Steps

- [Axios POST, PUT, DELETE](07_axios_post_put_delete.md)
