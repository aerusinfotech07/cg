# Axios POST, PUT, DELETE

## POST – Create

```javascript
const newItem = { name: "Book", price: 9.99 };
const response = await axios.post('http://127.0.0.1:8000/items', newItem);
console.log(response.data);
```

Axios sends the object as JSON by default (`Content-Type: application/json`).

## PUT – Update

```javascript
const id = 1;
const updated = { name: "Updated Book", price: 12.99 };
const response = await axios.put(`http://127.0.0.1:8000/items/${id}`, updated);
```

## DELETE – Remove

```javascript
const id = 1;
await axios.delete(`http://127.0.0.1:8000/items/${id}`);
```

## With axios Instance

```javascript
const api = axios.create({ baseURL: 'http://127.0.0.1:8000' });
await api.post('/items', { name: "Item", price: 5 });
await api.put('/items/1', { name: "Item", price: 6 });
await api.delete('/items/1');
```

## Next Steps

- [Error Handling with Axios](08_error_handling_axios.md)
