const { useEffect, useRef, useState } = React;

function RenderCounterCard() {
  const [inputValue, setInputValue] = useState("");
  const renderCount = useRef(0);

  useEffect(() => {
    renderCount.current += 1;
  });

  return (
    <section className="card">
      <h2>Render Counter</h2>
      <p className="muted">
        Tracks how many times this component re-renders using a ref.
      </p>
      <input
        placeholder="Type to re-render"
        value={inputValue}
        onChange={(event) => setInputValue(event.target.value)}
      />
      <p>Renders: {renderCount.current}</p>
    </section>
  );
}

function FocusInputCard() {
  const inputRef = useRef(null);

  useEffect(() => {
    if (inputRef.current) {
      inputRef.current.focus();
    }
  }, []);

  return (
    <section className="card">
      <h2>Auto Focus</h2>
      <p className="muted">Focuses the input on mount using a ref.</p>
      <input ref={inputRef} placeholder="I get focus on load" />
      <div className="row" style={{ marginTop: "8px" }}>
        <button onClick={() => inputRef.current?.focus()}>Focus Again</button>
      </div>
    </section>
  );
}

function PreviousValueCard() {
  const [name, setName] = useState("");
  const previousName = useRef("");

  useEffect(() => {
    previousName.current = name;
  }, [name]);

  return (
    <section className="card">
      <h2>Previous Value</h2>
      <p className="muted">
        Stores the previous value without causing extra re-renders.
      </p>
      <input
        placeholder="Type a name"
        value={name}
        onChange={(event) => setName(event.target.value)}
      />
      <p>Current: {name || "(empty)"}</p>
      <p>Previous: {previousName.current || "(empty)"}</p>
    </section>
  );
}

function App() {
  return (
    <main className="grid">
      <RenderCounterCard />
      <FocusInputCard />
      <PreviousValueCard />
    </main>
  );
}

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(<App />);
