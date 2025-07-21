const API_URL = "http://localhost:8080/api/products";

document.getElementById("productForm").addEventListener("submit", async (e) => {
  e.preventDefault();

  const product = {
    name: document.getElementById("name").value,
    brand: document.getElementById("brand").value,
    category: document.getElementById("category").value,
    purchaseDate: document.getElementById("purchaseDate").value,
    warrantyExpiry: document.getElementById("warrantyExpiry").value,
    billImageUrl: document.getElementById("billImageUrl").value,
  };

  await fetch(API_URL, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(product),
  });

  document.getElementById("productForm").reset();
  loadProducts();
});

async function loadProducts() {
  const res = await fetch(API_URL);
  const products = await res.json();

  const tbody = document.getElementById("productList");
  tbody.innerHTML = "";

  products.forEach((p) => {
    const row = document.createElement("tr");
    row.innerHTML = `
      <td>${p.name}</td>
      <td>${p.brand}</td>
      <td>${p.category}</td>
      <td>${p.purchaseDate}</td>
      <td>${p.warrantyExpiry}</td>
      <td><img src="${p.billImageUrl}" width="80" /></td>
      <td><button onclick="deleteProduct(${p.id})">Delete</button></td>
    `;
    tbody.appendChild(row);
  });
}

async function deleteProduct(id) {
  await fetch(`${API_URL}/${id}`, { method: "DELETE" });
  loadProducts();
}

// Initial load
loadProducts();
