function validateXY() {
    const x = document.getElementById("x").value;
    const y = document.getElementById("y").value;
    const r = document.getElementsByName("r");
    const floatPattern = /^-?\d*\.?\d+$/;

    if (!floatPattern.test(y)) {
        alert("y не подходит")
        return false;
    }

    if (y <= -5 || y >= 3) {
        alert("y не подходит")
        return false;
    }

    let picked = false;
    for (let i = 0; i < r.length; i++) {
        if (r[i].checked) {
            picked = true;
            break;
        }
    }
    if (!picked) {
        alert("r не выбран")
        return false;
    }

    return true;
}