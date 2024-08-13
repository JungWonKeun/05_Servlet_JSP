const deleteBtnList = document.querySelectorAll(".delete-btn");

// for of : 향상된 for문
for(let btn of deleteBtnList){
  btn.addEventListener("click", e => {
    if(!confirm("정말 탈퇴 하시겠습니까?")) return;

    const index = e.target.dataset.index;

    location.href = "/deleteMember?index=" + index;
  })
}

if (document.body.animate) {
  document
      .querySelectorAll(".button")
      .forEach((button) => button.addEventListener("click", pop));
}

function pop(e) {
  for (let i = 0; i < 30; i++) {
      createParticle(e.clientX, e.clientY, e.target.dataset.type);
  }
}

function createParticle(x, y, type) {
  const particle = document.createElement("particle");
  document.body.appendChild(particle);

  const size = Math.floor(Math.random() * 20 + 5);
  const destinationX = x + (Math.random() - 0.5) * 2 * 75;
  const destinationY = y + (Math.random() - 0.5) * 2 * 75;

  particle.style.width = `${size}px`;
  particle.style.height = `${size}px`;
  particle.style.background = type === "square"
      ? `hsl(${Math.random() * 90 + 270}, 70%, 60%)`
      : `hsl(${Math.random() * 90 + 180}, 70%, 60%)`;

  if (type === "circle") {
      particle.style.borderRadius = "50%";
  }

  const animation = particle.animate(
      [
          {
              transform: `translate(${x - size / 2}px, ${y - size / 2}px)`,
              opacity: 1,
          },
          {
              transform: `translate(${destinationX}px, ${destinationY}px)`,
              opacity: 0,
          },
      ],
      {
          duration: 500 + Math.random() * 1000,
          easing: "cubic-bezier(0, .9, .57, 1)",
          delay: Math.random() * 200,
      }
  );

  animation.onfinish = () => {
      particle.remove();
  };
}
