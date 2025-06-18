function updateClock() {
  const now = new Date();
  const formattedTime = now.toLocaleTimeString();
  const formattedDate = now.toLocaleDateString();
  document.getElementById('clock').textContent = `${formattedDate} ${formattedTime}`;
}

function updateClockLoop() {
  updateClock();
  setInterval(updateClock, 8000);
}

