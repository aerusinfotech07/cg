(function () {
  var statusEl = document.getElementById('status');
  var logEl = document.getElementById('log');
  var inputEl = document.getElementById('text');
  var sendBtn = document.getElementById('send');

  function logLine(text, meta) {
    var div = document.createElement('div');
    div.className = 'msg';
    div.textContent = text;
    if (meta) {
      var m = document.createElement('div');
      m.className = 'meta';
      m.textContent = meta;
      div.appendChild(m);
    }
    logEl.appendChild(div);
    logEl.scrollTop = logEl.scrollHeight;
  }

  function poll() {
    statusEl.textContent = 'Waiting for server...';
    fetch('updates', { cache: 'no-store' })
      .then(function (res) { return res.json(); })
      .then(function (data) {
        if (data.type === 'message') {
          logLine(data.text, 'Received @ ' + data.ts);
        } else if (data.type === 'timeout') {
          logLine('No new messages (timeout).', 'Client will re-connect.');
        }
      })
      .catch(function () {
        logLine('Connection error. Retrying...', 'Check server or network.');
      })
      .finally(function () {
        setTimeout(poll, 300);
      });
  }

  sendBtn.addEventListener('click', function () {
    var text = inputEl.value.trim();
    if (!text) return;

    var body = 'text=' + encodeURIComponent(text);
    fetch('send', {
      method: 'POST',
      headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
      body: body
    })
      .then(function () { inputEl.value = ''; })
      .catch(function () { logLine('Send failed.', 'Try again.'); });
  });

  poll();
})();
