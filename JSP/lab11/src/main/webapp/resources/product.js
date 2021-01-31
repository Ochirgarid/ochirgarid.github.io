window.onload = function () {
    let buttons=window.document.getElementsByName("add");
    Array.from(buttons).forEach((element) =>
        element.onclick=addToCard
    );
}

function addToCard(e){
    let product_id=this.value;
    alert(this.value);
    fetch('products', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: this.value,
    })
        .then(response => response.json())
        .then(data => processData(data))
        .catch((error) => {
            console.error('Error:', error);
        });
    //e.target.reset();
    //e.preventDefault();
}

function addProduct(e) {
    let productName = document.getElementById('product_name').value;
    let productPrice = document.getElementById('product_price').value;
    let product = {name: productName, price: productPrice};
    fetch('product', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(product),
    })
        .then(response => response.json())
        .then(data => processData(data))
        .catch((error) => {
            console.error('Error:', error);
        });
    e.target.reset();
    e.preventDefault();
}

function processData(data) {
    let tr = document.createElement('tr');
    for (let key in data) {
        let td = document.createElement('td');
        td.innerText = data[key];
        tr.append(td);
    }
    document.querySelector("#tbl_products>tbody").append(tr);
}


