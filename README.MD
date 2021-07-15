// 20210715163543
// http://localhost:8080/v3/api-docs

{
  "openapi": "3.0.1",
  "info": {
    "title": "OpenAPI definition",
    "version": "v0"
  },
  "servers": [
    {
      "url": "http://localhost:8080",
      "description": "Generated server url"
    }
  ],
  "paths": {
    "/property/value": {
      "post": {
        "tags": [
          "property-controller"
        ],
        "operationId": "calculateValue",
        "requestBody": {
          "content": {
            "application/json": {
              "schema": {
                "$ref": "#/components/schemas/PropertyDTO"
              }
            }
          }
        },
        "responses": {
          "200": {
            "description": "default response",
            "content": {
              "*/*": {
                "schema": {
                  "type": "string"
                }
              }
            }
          },
          "400": {
            "description": "default response",
            "content": {
              "*/*": {
                "schema": {
                  "oneOf": [
                    {
                      "type": "string"
                    },
                    {
                      "type": "array",
                      "items": {
                        "$ref": "#/components/schemas/ValidationError"
                      }
                    }
                  ]
                }
              }
            }
          }
        }
      }
    },
    "/district/": {
      "get": {
        "tags": [
          "district-controller"
        ],
        "operationId": "index",
        "responses": {
          "200": {
            "description": "default response",
            "content": {
              "*/*": {
                "schema": {
                  "type": "array",
                  "items": {
                    "$ref": "#/components/schemas/DistrictDTO"
                  }
                }
              }
            }
          },
          "400": {
            "description": "default response",
            "content": {
              "*/*": {
                "schema": {
                  "oneOf": [
                    {
                      "type": "string"
                    },
                    {
                      "type": "array",
                      "items": {
                        "$ref": "#/components/schemas/ValidationError"
                      }
                    }
                  ]
                }
              }
            }
          }
        }
      },
      "post": {
        "tags": [
          "district-controller"
        ],
        "operationId": "create",
        "requestBody": {
          "content": {
            "application/json": {
              "schema": {
                "$ref": "#/components/schemas/DistrictDTO"
              }
            }
          }
        },
        "responses": {
          "200": {
            "description": "default response",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/DistrictDTO"
                }
              }
            }
          },
          "400": {
            "description": "default response",
            "content": {
              "*/*": {
                "schema": {
                  "oneOf": [
                    {
                      "type": "string"
                    },
                    {
                      "type": "array",
                      "items": {
                        "$ref": "#/components/schemas/ValidationError"
                      }
                    }
                  ]
                }
              }
            }
          }
        }
      }
    },
    "/property/m2": {
      "post": {
        "tags": [
          "property-controller"
        ],
        "operationId": "calculateM2",
        "requestBody": {
          "content": {
            "application/json": {
              "schema": {
                "$ref": "#/components/schemas/PropertyDTO"
              }
            }
          }
        },
        "responses": {
          "200": {
            "description": "default response",
            "content": {
              "*/*": {
                "schema": {
                  "type": "number",
                  "format": "double"
                }
              }
            }
          },
          "400": {
            "description": "default response",
            "content": {
              "*/*": {
                "schema": {
                  "oneOf": [
                    {
                      "type": "string"
                    },
                    {
                      "type": "array",
                      "items": {
                        "$ref": "#/components/schemas/ValidationError"
                      }
                    }
                  ]
                }
              }
            }
          }
        }
      }
    },
    "/property/biggestRoom": {
      "post": {
        "tags": [
          "property-controller"
        ],
        "operationId": "biggestRoom",
        "requestBody": {
          "content": {
            "application/json": {
              "schema": {
                "$ref": "#/components/schemas/PropertyDTO"
              }
            }
          }
        },
        "responses": {
          "200": {
            "description": "default response",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/RoomDTO"
                }
              }
            }
          },
          "400": {
            "description": "default response",
            "content": {
              "*/*": {
                "schema": {
                  "oneOf": [
                    {
                      "type": "string"
                    },
                    {
                      "type": "array",
                      "items": {
                        "$ref": "#/components/schemas/ValidationError"
                      }
                    }
                  ]
                }
              }
            }
          }
        }
      }
    },
    "/property/rooms/m2": {
      "post": {
        "tags": [
          "property-controller"
        ],
        "operationId": "roomsM2",
        "requestBody": {
          "content": {
            "application/json": {
              "schema": {
                "$ref": "#/components/schemas/PropertyDTO"
              }
            }
          }
        },
        "responses": {
          "200": {
            "description": "default response",
            "content": {
              "*/*": {
                "schema": {
                  "type": "array",
                  "items": {
                    "$ref": "#/components/schemas/RoomM2DTO"
                  }
                }
              }
            }
          },
          "400": {
            "description": "default response",
            "content": {
              "*/*": {
                "schema": {
                  "oneOf": [
                    {
                      "type": "string"
                    },
                    {
                      "type": "array",
                      "items": {
                        "$ref": "#/components/schemas/ValidationError"
                      }
                    }
                  ]
                }
              }
            }
          }
        }
      }
    }
  },
  "components": {
    "schemas": {
      "ValidationError": {
        "type": "object",
        "properties": {
          "field": {
            "type": "string"
          },
          "message": {
            "type": "string"
          },
          "rejectedValue": {
            "type": "string"
          }
        }
      },
      "DistrictDTO": {
        "required": [
          "prop_district",
          "value_district_m2"
        ],
        "type": "object",
        "properties": {
          "prop_district": {
            "maxLength": 45,
            "minLength": 0,
            "type": "string"
          },
          "value_district_m2": {
            "maximum": 9999999999.999,
            "exclusiveMaximum": false,
            "minimum": 1,
            "type": "number"
          }
        }
      },
      "PropertyDTO": {
        "required": [
          "prop_name"
        ],
        "type": "object",
        "properties": {
          "prop_name": {
            "maxLength": 30,
            "minLength": 0,
            "pattern": "^[A-Z].*",
            "type": "string"
          },
          "district": {
            "$ref": "#/components/schemas/DistrictDTO"
          },
          "rooms": {
            "type": "array",
            "items": {
              "$ref": "#/components/schemas/RoomDTO"
            }
          }
        }
      },
      "RoomDTO": {
        "required": [
          "room_length",
          "room_name",
          "room_width"
        ],
        "type": "object",
        "properties": {
          "room_name": {
            "maxLength": 30,
            "minLength": 0,
            "pattern": "^[A-Z].*",
            "type": "string"
          },
          "room_width": {
            "maximum": 25.0,
            "exclusiveMaximum": false,
            "minimum": 1,
            "type": "number",
            "format": "double"
          },
          "room_length": {
            "maximum": 33.0,
            "exclusiveMaximum": false,
            "minimum": 1,
            "type": "number",
            "format": "double"
          },
          "m2": {
            "type": "number",
            "format": "double"
          }
        }
      },
      "RoomM2DTO": {
        "type": "object",
        "properties": {
          "name": {
            "type": "string"
          },
          "m2": {
            "type": "number",
            "format": "double"
          }
        }
      }
    }
  }
}