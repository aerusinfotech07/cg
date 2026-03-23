# React Hooks Practical + Simple Assignments

Each topic has:
- Simple Assignment (small, quick project)
- Practical Assignment (slightly bigger mini-project)

---

## 1) useState - UI State Practice
Simple Assignment (Mini Project): Color Picker Card
Create a card that lets users choose a color and shows the current choice.

Practical Assignment (Project): Grocery List Manager
Users can add, edit, and remove grocery items. Show total item count.

Requirements
- All UI state managed with useState.
- Form validation for empty input.
- Save list to localStorage.

---

## 2) useEffect - Side Effects Practice
Simple Assignment (Mini Project): Auto Counter
Start a counter on load that increments every second; add a stop button.

Practical Assignment (Project): Daily Quotes Viewer
Fetch a quote on load and allow "Get New Quote." Show loading and error states.

Requirements
- Use useEffect for timers and data fetching.
- Cleanup intervals on unmount.

---

## 3) useContext - Shared State Practice
Simple Assignment (Mini Project): Theme Switcher
Light/Dark mode that updates the whole app.

Practical Assignment (Project): Student Profile Portal
Store a mock logged-in student profile (name, course, year) in context and display it in multiple pages/components.

Requirements
- Create a Context + Provider.
- No prop drilling for theme/profile data.

---

## 4) useRef - DOM and Mutable Values Practice
Simple Assignment (Mini Project): Focus Helper
Input box with a Focus button using useRef.

Practical Assignment (Project): Form Wizard
Multi-step form with Next/Back. Auto-focus the first input of each step.

Requirements
- Use useRef for DOM access.
- No direct DOM queries.

---

## 5) useReducer - Complex State Practice
Simple Assignment (Mini Project): Counter with Actions
Buttons: increment, decrement, reset.

Practical Assignment (Project): Habit Tracker
Users add habits, toggle completion, and remove habits.

Requirements
- All state managed via useReducer.
- Action types documented in code comments or README.

---

## 6) useCallback - Memoized Handlers Practice
Simple Assignment (Mini Project): Button Panel
Two buttons update two separate counters. Memoize the handlers.

Practical Assignment (Project): Product Cards
Display a list of products. Each card has Like and Add to Cart. Memoize callbacks passed to card components.

Requirements
- Use useCallback for handlers passed to child components.
- Show render counts in console or UI.

---

## 7) useMemo - Memoized Values Practice
Simple Assignment (Mini Project): Number Filter
Generate 1-5000 numbers; filter evens/odds. Memoize filtered results.

Practical Assignment (Project): Sales Summary
Upload JSON data and compute totals, average, and top category. Memoize the calculations.

Requirements
- Use useMemo for expensive computations.
- Recompute only when inputs change.

---

## 8) Custom Hooks - Reuse Practice
Simple Assignment (Mini Project): useLocalStorage Theme
Create useLocalStorage and use it to persist a theme toggle.

Practical Assignment (Project): useFetch + useForm App
Create useFetch for data loading and useForm for validation. Build a small app that submits a form and displays fetched data.

Requirements
- Custom hooks must start with use.
- Each hook used in at least one component.

---

## W3Schools References
- https://www.w3schools.com/react/react_usestate.asp
- https://www.w3schools.com/react/react_useeffect.asp
- https://www.w3schools.com/react/react_usecontext.asp
- https://www.w3schools.com/react/react_useref.asp
- https://www.w3schools.com/react/react_usereducer.asp
- https://www.w3schools.com/react/react_usecallback.asp
- https://www.w3schools.com/react/react_usememo.asp
- https://www.w3schools.com/react/react_customhooks.asp

---

## Submission Schedule (Weekly)
Start date: February 10, 2026 (Tuesday)

1) useState - Due: February 17, 2026 (Tuesday)
2) useEffect - Due: February 24, 2026 (Tuesday)
3) useContext - Due: March 3, 2026 (Tuesday)
4) useRef - Due: March 10, 2026 (Tuesday)
5) useReducer - Due: March 17, 2026 (Tuesday)
6) useCallback - Due: March 24, 2026 (Tuesday)
7) useMemo - Due: March 31, 2026 (Tuesday)
8) Custom Hooks - Due: April 7, 2026 (Tuesday)

---

## Grading Rubric (100 points)
- Functionality & completeness: 40
- Correct React hook usage: 25
- Code quality (readability, structure, reuse): 15
- UI/UX (clarity, basic styling, usability): 10
- README (setup steps + screenshots): 10

---

## Submission Requirements
- Source code in a project folder per assignment.
- README with setup, features, and screenshots.
- Include a short note on where each hook is used.
