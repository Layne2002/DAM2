interface Producto {
  descripcion: string;
  precio: number;
}

const telefono: Producto = {
  descripcion: "iPhone 15 Pro",
  precio: 1000,
};

const tablet: Producto = {
  descripcion: "iPad Air 3",
  precio: 500,
};

interface CalculaImpuestoOpciones {
  impuesto: number;
  productos: Producto[];
}
// recibimos el impuesto y productos directamente
function calculaImpuesto({
  impuesto,
  productos,
}: CalculaImpuestoOpciones): number[] {
  let total = 0;
  productos.forEach(({ precio }) => {
    total += precio;
  });
  return [total, total * impuesto];
}

// desestructuracion para obtener propiedades
const { descripcion: descTelefono, precio: precioTelefono } = telefono;
const { descripcion: descTablet, precio: precioTablet } = tablet;

const carritoCompra = [
  { descripcion: descTelefono, precio: precioTelefono },
  { descripcion: descTablet, precio: precioTablet },
];
const impuesto = 0.21;

// desetructuracion para obtener el precio
const [totalCompra, totalImpuesto] = calculaImpuesto({
  productos: carritoCompra,
  impuesto,
});

// mostrando total y total con impuestos
console.table(`Total: ${totalCompra} , impuestos: ${totalImpuesto}`);

// desestructuracion para el producto 2 del carrito
const [, producto2] = carritoCompra;
const { descripcion, precio } = producto2;
console.table(
  `El segundo objeto que tienes en el carrito es ${descripcion}, con precio: ${precio}`
);

// salida de consola
console.log(`Producto 1: ${descTelefono}, Precio: ${precioTelefono}`);
console.log(`Producto 2: ${descTablet}, Precio: ${precioTablet}`);
console.log(`Compra total: ${totalCompra}`);
console.log(`Compra total con impuesto: ${totalImpuesto}`);

export {};
