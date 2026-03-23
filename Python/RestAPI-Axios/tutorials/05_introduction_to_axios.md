# Introduction to Axios

## What is Axios?

**Axios** is a JavaScript HTTP client. It runs in the browser or in Node.js and is used to call REST APIs.

## Include Axios in HTML (CDN)

```html
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
```

## Basic GET Request

```javascript
axios.get('http://127.0.0.1:8000/items')
  .then(function (response) {
    console.log(response.data);
  })
  .catch(function (error) {
    console.error(error);
  });
```

## With async/await

```javascript
async function fetchItems() {
  try {
    const response = await axios.get('http://127.0.0.1:8000/items');
    console.log(response.data);
  } catch (error) {
    console.error(error);
  }
}
```

## Response Object

- `response.data` – response body (usually JSON)
- `response.status` – HTTP status code
- `response.headers` – response headers

## Next Steps

- [Axios GET Requests](06_axios_get_requests.md)
