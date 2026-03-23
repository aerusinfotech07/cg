# Error Handling with Axios

## try/catch

```javascript
try {
  const response = await axios.get('http://127.0.0.1:8000/items/999');
  console.log(response.data);
} catch (error) {
  if (error.response) {
    console.log('Status:', error.response.status);
    console.log('Data:', error.response.data);
  } else {
    console.error(error.message);
  }
}
```

## error.response

When the server responds with an error status (4xx, 5xx):

- `error.response.status` – HTTP status code
- `error.response.data` – response body (e.g. validation errors from FastAPI)
- `error.response.headers` – response headers

## No response (network error)

If the request fails before a response (e.g. network error), `error.response` is undefined. Use `error.message` or `error.request`.

## Displaying Validation Errors (FastAPI)

FastAPI returns 422 with a `detail` array for validation errors:

```javascript
if (error.response?.status === 422) {
  const details = error.response.data.detail;
  details.forEach(err => console.log(err.msg, err.loc));
}
```

## Next Steps

- [Full Example: API + Frontend](09_full_example.md)
