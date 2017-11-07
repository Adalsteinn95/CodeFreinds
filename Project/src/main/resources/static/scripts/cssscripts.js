

document.getElementById('alreadyAccount').onclick = () => {
  document.getElementById('signup').style.display = "none";
  document.getElementById('signin').style.display = "flex";

}
document.getElementById('notAlreadyAccount').onclick = () => {
  document.getElementById('signup').style.display = "flex";
  document.getElementById('signin').style.display = "none";

}
