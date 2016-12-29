angular
		.module('myApp', [ 'ngCart.directives' ])

		.config([ function() {

		} ])

		.provider('$ngCart', function() {
			this.$get = function() {
			};
		})

		.run(
				[ '$rootScope', 'ngCart', 'ngCartItem', 'store',
						function($rootScope, ngCart, ngCartItem, store) {

							$rootScope.$on('ngCart:change', function() {
								ngCart.$save();
							});

							if (angular.isObject(store.get('cart'))) {
								ngCart.$restore(store.get('cart'));

							} else {
								ngCart.init();
							}

						} ])
						
		.service(
				'ngCart',
				[
						'$rootScope',
						'$window',
						'ngCartItem',
						'store',
						'$http',
						function($rootScope, $window, ngCartItem, store, $http) {

							this.init = function() {
								this.$cart = {
									shipping : null,
									paymentFee : null,
									taxRate : null,
									tax : null,
									items : []
								};
							};
							this.addItem = function(id, name, price, quantity,
									data, imagePath) {
								if(!(quantity != null && quantity > 0)){
									$('#quantityAlertMsg').html("<span class='alert alert-info'><strong>Info!</strong> Please enter Quantity.</span>");
									return;
								} else {
									$('#quantityAlertMsg').html("");
								}
								$('html, body').animate({
						            'scrollTop' : $('#cart button .fa-shopping-cart').position().top
						        });
								var itemImg = $('#product_'+id);
								this.flyToElement($(itemImg), $('#cart button .fa-shopping-cart'));

								var inCart = this.getItemById(id);
								if (typeof inCart === 'object') {
									// Update quantity of an item if it's
									// already in the cart
									inCart.setQuantity(quantity, false);
									$rootScope.$broadcast('ngCart:itemUpdated',
											inCart);
								} else {
									var newItem = new ngCartItem(id, name,
											price, quantity, data, imagePath);
									this.$cart.items.push(newItem);
									$rootScope.$broadcast('ngCart:itemAdded',
											newItem);
								}

								$rootScope.$broadcast('ngCart:change', {});
							};
							
							this.addItemFromDB = function(id, name, price, quantity,data,imagePath) {
								var newItem = new ngCartItem(id, name,
										price, quantity, data, imagePath);
								this.$cart.items.push(newItem);
								$rootScope.$broadcast('ngCart:itemAdded',
										newItem);

								$rootScope.$broadcast('ngCart:change', {});
							};

							this.getItemById = function(itemId) {
								var items = this.getCart().items;
								var build = false;

								angular.forEach(items, function(item) {
									if (item.getId() === itemId) {
										build = item;
									}
								});
								return build;
							};

							this.setShipping = function(shipping) {
								this.$cart.shipping = shipping;
								return this.getShipping();
							};

							this.getShipping = function() {
								if (this.getCart().items.length == 0)
									return 0;
								return 10;//this.getCart().shipping;
							};
							
							this.setPaymentFee = function(paymentFee) {
								this.$cart.paymentFee = paymentFee;
								return this.getPaymentFee();
							};

							this.getPaymentFee = function() {
								return 15;//this.getCart().shipping;
							};

							this.setTaxRate = function(taxRate) {
								this.$cart.taxRate = +parseFloat(taxRate)
										.toFixed(2);
								return this.getTaxRate();
							};

							this.getTaxRate = function() {
								return this.$cart.taxRate
							};

							this.getTax = function() {
								return +parseFloat(
										((this.getSubTotal() / 100) * this
												.getCart().taxRate)).toFixed(2);
							};
							this.getVat = function() {
								return +parseFloat(
										((this.getSubTotal() * 17.5) / 100))
										.toFixed(2);
							};
							this.setCart = function(cart) {
								this.$cart = cart;
								return this.getCart();
							};

							this.getCart = function() {
								return this.$cart;
							};

							this.getItems = function() {
								return this.getCart().items;
							};

							this.getTotalItems = function() {
								var count = 0;
								var items = this.getItems();
								angular.forEach(items, function(item) {
									count += item.getQuantity();
								});
								return count;
							};

							this.getTotalUniqueItems = function() {
								return this.getCart().items.length;
							};

							this.getSubTotal = function() {
								var total = 0;
								angular.forEach(this.getCart().items, function(
										item) {
									total += item.getTotal();
								});
								return +parseFloat(total).toFixed(2);
							};

							this.totalCost = function() {
								return +parseFloat(
										this.getSubTotal() + this.getShipping()
												+ this.getTax() + this.getVat())
										.toFixed(2);
							};

							this.removeItem = function(index) {
								var item = this.$cart.items.splice(index, 1)[0]
										|| {};
								$rootScope.$broadcast('ngCart:itemRemoved',
										item);
								$rootScope.$broadcast('ngCart:change', {});

							};

							this.removeItemById = function(id) {
								var item;
								var cart = this.getCart();
								angular.forEach(cart.items, function(item,
										index) {
									if (item.getId() === id) {
										item = cart.items.splice(index, 1)[0]
												|| {};
									}
								});
								this.setCart(cart);
								$rootScope.$broadcast('ngCart:itemRemoved',
										item);
								$rootScope.$broadcast('ngCart:change', {});
							};

							this.empty = function() {

								$rootScope.$broadcast('ngCart:change', {});
								this.$cart.items = [];
								$window.localStorage.removeItem('cart');
							};

							this.isEmpty = function() {

								return (this.$cart.items.length > 0 ? false
										: true);

							};

							this.toObject = function() {

								if (this.getItems().length === 0)
									return false;

								var items = [];
								angular.forEach(this.getItems(),
										function(item) {
											items.push(item.toObject());
										});

								return {
									shipping : this.getShipping(),
									paymentFee : this.getPaymentFee(),
									tax : this.getTax(),
									taxRate : this.getTaxRate(),
									subTotal : this.getSubTotal(),
									totalCost : this.totalCost(),
									items : items
								}
							};

							this.$restore = function(storedCart) {
								var _self = this;
								_self.init();
								_self.$cart.shipping = storedCart.shipping;
								_self.$cart.paymentFee = storedCart.paymentFee;
								_self.$cart.tax = storedCart.tax;

								angular.forEach(storedCart.items,
										function(item) {
											_self.$cart.items
													.push(new ngCartItem(
															item._id,
															item._name,
															item._price,
															item._quantity,
															item._data,
															item.imagePath));
										});
								this.$save();
							};

							this.$save = function() {
								return store.set('cart', JSON.stringify(this
										.getCart()));
							};
							
							this.flyToElement = function(flyer, flyingTo) {
							    var $func = $(this);
							    var divider = 3;
							    var flyerClone = $(flyer).clone();
							    $(flyerClone).css({
							    	position: 'absolute', 
							    	top: $(flyer).offset().top + "px", 
							    	left: $(flyer).offset().left + "px", 
							    	width:$(flyer).width(),
							    	height:$(flyer).height(),
							    	opacity: 1, 
							    	'z-index': 1000
							    });
							    $('body').append($(flyerClone));
							    var gotoX = $(flyingTo).offset().left + ($(flyingTo).width() / 2) - ($(flyer).width()/divider)/2;
							    var gotoY = $(flyingTo).offset().top + ($(flyingTo).height() / 2) - ($(flyer).height()/divider)/2;
							     
							    $(flyerClone).animate({
							        opacity: 0.4,
							        left: gotoX,
							        top: gotoY,
							        width: $(flyer).width()/divider,
							        height: $(flyer).height()/divider
							    }, 700,
							    function () {
							        $(flyingTo).fadeOut('fast', function () {
							            $(flyingTo).fadeIn('fast', function () {
							                $(flyerClone).fadeOut('fast', function () {
							                    $(flyerClone).remove();
							                });
							            });
							        });
							    });
							};

						} ])

		.factory(
				'ngCartItem',
				[
						'$rootScope',
						'$log',
						function($rootScope, $log) {

							var item = function(id, name, price, quantity,
									data, imagePath) {
								this.setId(id);
								this.setName(name);
								this.setPrice(price);
								this.setQuantity(quantity);
								this.setData(data);
								this.setImagePath(imagePath);
							};

							item.prototype.setId = function(id) {
								if (id)
									this._id = id;
								else {
									$log.error('An ID must be provided');
								}
							};

							item.prototype.getId = function() {
								return this._id;
							};

							item.prototype.setName = function(name) {
								if (name)
									this._name = name;
								else {
									$log.error('A name must be provided');
								}
							};
							item.prototype.getName = function() {
								return this._name;
							};

							item.prototype.setPrice = function(price) {
								var priceFloat = parseFloat(price);
								if (priceFloat) {
									if (priceFloat <= 0) {
										$log.error('A price must be over 0');
									} else {
										this._price = (priceFloat);
									}
								} else {
									$log.error('A price must be provided');
								}
							};
							item.prototype.getPrice = function() {
								return this._price;
							};

							item.prototype.setQuantity = function(quantity,
									relative) {

								var quantityInt = parseInt(quantity);
								if (quantityInt % 1 === 0) {
									if (relative === true) {
										this._quantity += quantityInt;
									} else {
										this._quantity = quantityInt;
									}
									if (this._quantity < 1)
										this._quantity = 1;

								} else {
									this._quantity = 1;
									$log
											.info('Quantity must be an integer and was defaulted to 1');
								}
								$rootScope.$broadcast('ngCart:change', {});

							};

							item.prototype.setImagePath = function(imagePath) {
								if (imagePath)
									this._imagePath = imagePath;
								else {
									$log
											.error('An Image Path must be provided');
								}
							}
							item.prototype.getQuantity = function() {
								return this._quantity;
							};

							item.prototype.setData = function(data) {
								if (data)
									this._data = data;
							};

							item.prototype.getData = function() {
								if (this._data)
									return this._data;
								else
									$log.info('This item has no data');
							};

							item.prototype.getTotal = function() {
								return +parseFloat(
										this.getQuantity() * this.getPrice())
										.toFixed(2);
							};

							item.prototype.getImagePath = function() {
								return this._imagePath;
							};

							item.prototype.toObject = function() {
								return {
									id : this.getId(),
									name : this.getName(),
									price : this.getPrice(),
									quantity : this.getQuantity(),
									data : this.getData(),
									total : this.getTotal(),
									imagePath : this.getImagePath()
								}
							};

							return item;

						} ])

		.service(
				'store',
				[
						'$window',
						function($window) {

							return {

								get : function(key) {
									if ($window.localStorage.getItem(key)) {
										var cart = angular
												.fromJson($window.localStorage
														.getItem(key));
										return JSON.parse(cart);
									}
									return false;

								},

								set : function(key, val) {

									if (val === undefined) {
										$window.localStorage.removeItem(key);
									} else {
										$window.localStorage.setItem(key,
												angular.toJson(val));
									}
									return $window.localStorage.getItem(key);
								}
							}
						} ])

		.controller('CartController',
				[ '$scope', 'ngCart','$http', 
				  function($scope, ngCart, $http) {
						$scope.ngCart = ngCart;
						
						$scope.addCartItemsOnLogout = function(){
							$http({
								method : 'GET',
								url : 'http://localhost:8080/eCommerce/addCartItems/'+ angular.toJson(ngCart.getCart().items)
							}).success(function(data, status, headers, config) {
								ngCart.empty();
								document.getElementById('logout').submit();
							});
						};
				} ])
		
		.controller('CartDBController',
			[ '$scope', '$http', 'ngCart', function($scope, $http, ngCart) {
				$scope.ngCart = ngCart;
				
				ngCart.init();
				$http({
					method : 'GET',
					url : 'http://localhost:8080/eCommerce/getCartDetails/'
				}).success(function(data, status, headers, config) {
					$scope.cartDetails=data;
					for(var i=0; i<data.length;i++) {
						var id = data[i][0];
						var price = data[i][1];
						var name = data[i][2];
						var quantity = data[i][3];
						ngCart.addItemFromDB(id, name, price, quantity,null,null);
					}
				});
			} ])
		
		.controller(
				'LatestProductController',
				function($scope, $http) {
					$http
							.get(
									'http://localhost:8080/eCommerce/getLatestProducts/')
							.success(function(data) {
								$scope.latestProducts = data;
							});
				})

		.controller(
				'FeatureProductController',
				function($scope, $http) {
					$http
							.get(
									'http://localhost:8080/eCommerce/getFeaturedProducts/')
							.success(function(data) {
								$scope.featuredProducts = data;
							});
				})
				
		.controller('CategoryProductListController', function($scope, $http){
			$http({
				method : 'GET',
				url : 'http://localhost:8080/eCommerce/getProductsByCategory/' + $scope.categoryId
			}).success(function(data, status, headers, config) {
				$scope.categoryProducts=data;
			})
		})
		
		.controller('CategoryMenuController', function($scope, $http) {
			$http.get('http://localhost:8080/eCommerce/geAllMenuCategories/').success(
					function(data) {
						$scope.menuCategories = data;
					});
		
		})
		.controller('OrderController',
				[ '$scope', '$http', 'ngCart','$window', function($scope, $http, ngCart,$window) {
					$scope.confirmOrder = function() {
						$http
						.get('http://localhost:8080/eCommerce/confirmOrder/'+ angular.toJson(ngCart.getCart().items))
						.then(function mySucces(response) {
							ngCart.init();
							$window.location.href = '/eCommerce/orderSuccess';
					    }, function myError(response) {
					    	alert("error");
					        return status;
					    });
					};
		} ])
		.controller('OrderSuccessController',
				[ '$scope','ngCart', function($scope,ngCart) {
				ngCart.empty();
				$scope.ngCart = ngCart;
		} ])
		.value('version', '1.0.0');

		
