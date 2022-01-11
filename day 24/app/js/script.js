console.log("Hello, this is my web development project");
console.log("Visit my GitHub to know more");

const menuBtn = document.querySelector(".menu-btn");
const menu = document.querySelector("nav ul");
const exitBtn = document.querySelector(".exit-btn");

menuBtn.addEventListener("click", () => {
  menu.style.transform = "translateX(0)";
});

exitBtn.addEventListener("click", () => {
  menu.style.transform = "translateX(100%)";
});
