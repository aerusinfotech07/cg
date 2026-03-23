# FastAPI - HTML Form Templates

## Form in Template

In `templates/form.html`:

```html
<form action="/submit" method="post">
  <input type="text" name="username" />
  <input type="password" name="password" />
  <button type="submit">Submit</button>
</form>
```

## Route to Show Form

```python
@app.get("/form")
def show_form(request: Request):
    return templates.TemplateResponse("form.html", {"request": request})
```

## Next Steps

- [Accessing Form Data](17_accessing_form_data.md)
