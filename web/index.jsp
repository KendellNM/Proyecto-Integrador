<%-- 
    Document   : newjsp
    Created on : 7 jun. 2024, 10:14:08
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
      <link href="./output.css" rel="stylesheet" />
      <script src="assets/cdn.tailwindcss.com.js"></script>
      <link
        rel="stylesheet"
        href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
      />
  </head>
  <body>
    <div
      class="bg-cover h-[100vh] bg-fixed bg-no-repeat bg-center"
      style="background-image: url('assets/img/login/fondo_login.jpeg')"
    >
      <div
        class="flex items-center justify-center h-screen max-w-full object-cover bg-no-repeat"
      >
        <div
          class="flex items-center justify-center bg-[#081114] bg-opacity-[58%] h-[35rem] w-[35rem] rounded-lg"
        >
          <div>
            <div class="flex items-center justify-center">
                <img src="assets/img/login/logo_upeu.png" width="200em" />
            </div>

            <div class="relative flex items-center justify-center mt-8">
              <input
                id="usuario"
                name="usuario"
                type="text"
                autocomplete="off"
                placeholder="Ingrese su usuario"
                required
                class="text-white border-b rounded-md border-gray-300 py-1 focus:border-b-2 focus:border-blue-700 transition-colors focus:outline-none peer bg-inherit w-[20rem]"
              />
              <i
                class="fas fa-user text-white bg-transparent absolute top-0 right-0 mt-2 mr-2"
              ></i>

              <label
                for="usuario"
                id="usuario_label"
                class="absolute left-0 top-1 text-gray-400"
                >Ingrese su usuario
              </label>
            </div>

            <div class="relative mt-8 flex items-center justify-center">
              <input
                id="contrasena"
                name="contrasena"
                type="password"
                autocomplete="off"
                placeholder="Ingrese su contraseña"
                required
                class="w-[20rem] text-white border-b rounded-md border-gray-300 py-1 focus:border-b-2 focus:border-blue-700 transition-colors focus:outline-none peer bg-inherit"
                type="password"
                id="password"
              />

              <i
                class="fa fa-eye text-white bg-transparent absolute top-0 right-0 mt-2 mr-2 hover:cursor-pointer"
                id="ver_contrasena"
                onclick="ver_contra()"
              ></i>

              <label
                for="contrasena"
                id="contrasena_label"
                class="absolute left-0 top-1 text-gray-400"
                >Ingrese su contraseña
              </label>
            </div>

            <div class="flex items-center justify-center">
              <button
                class="w-[20rem] h-9 shadow bg-[#304385] hover:bg-blue-400 focus:shadow-outline focus:outline-none text-white font-bold mt-5 px-4 rounded-[5rem]"
                type="button"
              >
                Iniciar sesión
              </button>
            </div>

            <div class="flex items-center justify-center mt-5">
              <div>
                <button
                  class="flex items-center justify-center w-[20rem] shadow border-black bg-transparent hover: cursor-pointer focus:shadow-outline focus:outline-none text-white font-bold mt-5 px-4 rounded"
                  type="button"
                >
                  <svg
                    class="h-5 px-1"
                    xmlns="http://www.w3.org/2000/svg"
                    viewBox="0 0 23 23"
                  >
                    <path fill="#f3f3f3" d="M0 0h23v23H0z" />
                    <path fill="#f35325" d="M1 1h10v10H1z" />
                    <path fill="#81bc06" d="M12 1h10v10H12z" />
                    <path fill="#05a6f0" d="M1 12h10v10H1z" />
                    <path fill="#ffba08" d="M12 12h10v10H12z" />
                  </svg>
                  Iniciar sesión con Microsoft
                </button>
              </div>
            </div>

            <div class="flex items-center justify-center mt-3">
              <label for="" class="text-white">
                ¿Has olvidado la contraseña?
              </label>
            </div>
          </div>
        </div>
      </div>
    </div>

      <script src="assets/js/jquery-3.7.1.min.js"></script>
      <script src="assets/js/login/script.js"></script>
  </body>
</html>
