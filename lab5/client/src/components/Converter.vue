<template>
    <div id="greeting" class="converter">
        <h3 class="headerStyle">Конвертер мер длины</h3>
        <div class="oneRaw">
            <div class="inputStyle">
                <b-form-input type="number" placeholder="0,0" v-model="inputEng"/>
            </div>
            <div class="dropdownStyle">
                <vue-dropdown :config="configLeftEng" @setSelectedOption="configLeftEngFunction($event)"></vue-dropdown>
            </div>
            <div class="pEqual">
                <p> = </p>
            </div>
            <div class="inputStyle">
                <b-form-input type="number" placeholder="0,0" v-model="outputMetr" disabled/>
            </div>
            <div class="dropdownStyle">
                <vue-dropdown :config="configRightMetrAndEng"
                              @setSelectedOption="configRightMetrAndEngFunction($event)"></vue-dropdown>
            </div>
        </div>
        <div class="oneRaw">
            <div class="inputStyle">
                <b-form-input type="number" placeholder="0,0" v-model="inputMetr"/>
            </div>
            <div class="dropdownStyle">
                <vue-dropdown :config="configLeftMetr"
                              @setSelectedOption="configLeftMetrFunction($event)"></vue-dropdown>
            </div>
            <div class="pEqual">
                <p> = </p>
            </div>
            <div class="inputStyle">
                <b-form-input type="number" placeholder="0,0" v-model="outputEng" disabled/>
            </div>
            <div class="dropdownStyle">
                <vue-dropdown :config="configRightEng"
                              @setSelectedOption="configRightEngFunction($event)"></vue-dropdown>
            </div>
        </div>
        <div class="buttonStyle">
            <b-button v-on:click="convert" variant="primary">Конвертировать</b-button>
        </div>
    </div>
</template>

<script>
    import axios from 'axios'
    import VueDropdown from 'vue-dynamic-dropdown';

    export default {
        data() {
            return {
                inputEng: '0,0',
                outputEng: '0,0',
                inputMetr: '0,0',
                outputMetr: '0,0',
                configLeftEng: {
                    placeholder: "футов",
                    options: [
                        {
                            value: "лиг"
                        },
                        {
                            value: "морских миль"
                        },
                        {
                            value: "кабельтов"
                        },
                        {
                            value: "фурлонгов"
                        },
                        {
                            value: "чейнов"
                        },
                        {
                            value: "родов"
                        },
                        {
                            value: "ярдов"
                        },
                        {
                            value: "футов"
                        },
                        {
                            value: "хэндов"
                        },
                        {
                            value: "барликорнов"
                        },
                        {
                            value: "дюймов"
                        },
                        {
                            value: "линий"
                        },
                        {
                            value: "точек"
                        },
                        {
                            value: "мил"
                        }
                    ],
                    backgroundColor: "gray",
                    hoverBackgroundColor: "gray",
                    border: "black"
                },
                configRightEng: {
                    placeholder: "футов",
                    options: [
                        {
                            value: "лиг"
                        },
                        {
                            value: "морских миль"
                        },
                        {
                            value: "кабельтов"
                        },
                        {
                            value: "фурлонгов"
                        },
                        {
                            value: "чейнов"
                        },
                        {
                            value: "родов"
                        },
                        {
                            value: "ярдов"
                        },
                        {
                            value: "футов"
                        },
                        {
                            value: "хэндов"
                        },
                        {
                            value: "барликорнов"
                        },
                        {
                            value: "дюймов"
                        },
                        {
                            value: "линий"
                        },
                        {
                            value: "точек"
                        },
                        {
                            value: "мил"
                        }
                    ],
                    backgroundColor: "gray",
                    hoverBackgroundColor: "gray",
                    border: "black"
                },
                configRightMetrAndEng: {
                    placeholder: "метров",
                    options: [
                        {
                            value: "метров"
                        },
                        {
                            value: "сантиметров"
                        },
                        {
                            value: "километров"
                        },
                        {
                            value: "миллиметров"
                        },
                        {
                            value: "лиг"
                        },
                        {
                            value: "морских миль"
                        },
                        {
                            value: "кабельтов"
                        },
                        {
                            value: "фурлонгов"
                        },
                        {
                            value: "чейнов"
                        },
                        {
                            value: "родов"
                        },
                        {
                            value: "ярдов"
                        },
                        {
                            value: "футов"
                        },
                        {
                            value: "хэндов"
                        },
                        {
                            value: "барликорнов"
                        },
                        {
                            value: "дюймов"
                        },
                        {
                            value: "линий"
                        },
                        {
                            value: "точек"
                        },
                        {
                            value: "мил"
                        }
                    ],
                    backgroundColor: "gray",
                    hoverBackgroundColor: "gray",
                    border: "black"
                },
                configLeftMetr: {
                    placeholder: "метров",
                    options: [
                        {
                            value: "метров"
                        },
                        {
                            value: "сантиметров"
                        },
                        {
                            value: "километров"
                        },
                        {
                            value: "миллиметров"
                        }
                    ],
                    backgroundColor: "gray",
                    hoverBackgroundColor: "gray",
                    border: "black"
                }
            }
        },
        components: {
            VueDropdown
        }
        ,
        methods: {
            configLeftEngFunction(event) {
                this.$data.configLeftEng.placeholder = event.value
            },
            configRightMetrAndEngFunction(event) {
                this.$data.configRightMetrAndEng.placeholder = event.value
                this.$data.outputMetr = "0,0"
            },
            configLeftMetrFunction(event) {
                this.$data.configLeftMetr.placeholder = event.value
            },
            configRightEngFunction(event) {
                this.$data.configRightEng.placeholder = event.value
                this.$data.outputEng = "0,0"
            },
            convert() {
                axios.get('/convert/to/meterOrEng', {
                    params: {
                        inputValue: this.$data.inputEng,
                        inputMeasurement: this.$data.configLeftEng.placeholder,
                        outputMeasurement: this.$data.configRightMetrAndEng.placeholder,
                    }
                }).then(response => {
                    this.$data.outputMetr = response.data.result;
                }).catch(error => {
                    console.log('ERROR: ' + error.response.data);
                })
                axios.get('/convert/to/eng', {
                    params: {
                        inputValue: this.$data.inputMetr,
                        inputMeasurement: this.$data.configLeftMetr.placeholder,
                        outputMeasurement: this.$data.configRightEng.placeholder,
                    }
                }).then(response => {
                    this.$data.outputEng = response.data.result;
                }).catch(error => {
                    console.log('ERROR: ' + error.response.data);
                })
            }
        }
    }
</script>
<style>
    .converter {
        margin-left: 25%;
        margin-top: 5%;
    }

    .oneRaw {
        display: flex;
    }

    .pEqual {
        font-size: 25px;
        margin: 5px 10px;
        width: 30px;
    }

    .dropdownStyle {
        width: 200px;
        margin: 5px 10px;
    }

    .inputStyle {
        width: 150px;
        margin-bottom: 5px;
        margin-top: 5px;
    }

    .headerStyle {
        margin-bottom: 50px;
        margin-left: 25%;
    }

    .buttonStyle {
        margin-top: 50px;
        margin-left: 25%;
    }
</style>