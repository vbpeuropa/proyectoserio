
var listaRelojesCtrl = relojesApp.controller(
		"listaRelojesCtrl", ["$scope", function($scope) {
			
			
			var marcaSeleccionada = null;
			
			$scope.paginaSeleccionada = 1;
			$scope.tamanioPagina = 3;
			
			$scope.seleccionarMarca = function(nuevaMarca) {
				// Comprobar si viene parámetro
				if(!angular.isDefined(nuevaMarca)) {
					// Boton de inicio
					marcaSeleccionada = null;
				} else {
					marcaSeleccionada = nuevaMarca;
				}
				
				$scope.paginaSeleccionada = 1;
			}
			
			$scope.resaltarMarca = function(nuevaMarca) {
				// Devolvemos clase CSS de Bootstrap btn-primary
				// para seleccionar el botón
				return marcaSeleccionada === nuevaMarca ?
						"btn-primary" : "";
			}
			
			$scope.resaltarPagina = function(pagina) {
				// Devolvemos clase CSS de Bootstrap btn-primary
				// para seleccionar el botón
				return $scope.paginaSeleccionada === pagina ?
						"btn-primary" : "";
			}
			
			$scope.seleccionarPagina = function(nuevaPagina) {
				// Actualizar la pagina seleccionada con la
				// pagina correspondiente al botón sobre el
				// que hemos pulsado
				return $scope.paginaSeleccionada = nuevaPagina;
			}
			
			/*
			 * Función para filtrar la matriz con los relojes
			 * dependiendo de la marca seleccionada
			 * 
			 * Hay que devolver true para cada reloj que queremos 
			 * que aparezca en la pagina
			 */
			$scope.filtrarPorMarca = function(reloj) {
				return marcaSeleccionada === null ||
					reloj.marca === marcaSeleccionada;
			}
			
			
		}]);