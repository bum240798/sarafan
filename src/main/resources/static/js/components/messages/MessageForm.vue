<template>
    <v-layout>
        <v-text-field
                label="new message"
                placeholder="Write something"
                v-model="text"
                @keyup.enter="save"
        />
        <v-btn @click="save">
            Save
        </v-btn>
    </v-layout>
</template>

<script>

    import { mapActions } from 'vuex'
    import * as Sentry from '@sentry/browser'

    export default {
        props: ['messageAttr'],
        data() {
            return {
                text: '',
                id: ''
                // id: null
            }
        },
        watch: {
            messageAttr: function (newVal, oldVal) {
                this.text = newVal.text
                this.id = newVal.id
            }
        },
        methods: {
            ...mapActions(['addMessageAction', 'updateMessageAction']),
            save() {
                const message = {
                    id: this.id,
                    text: this.text
                }

                if (this.id) {
                    this.updateMessageAction(message)
                } else {
                    this.addMessageAction(message)
                }
                this.text = ''
                this.id = ''
                // this.id = null
            }
        }
    }
</script>

<style>

</style>