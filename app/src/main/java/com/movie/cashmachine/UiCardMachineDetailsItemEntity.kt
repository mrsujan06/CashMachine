package com.movie.cashmachine

sealed class UiCardMachineDetailsItemEntity {
    abstract var name: String
    abstract val value: String
    abstract val description: String?
}

data class UiMachineNameEntity(
    override var name: String,
    override val value: String,
    override val description: String?
) : UiCardMachineDetailsItemEntity()

data class UiSerialNumberEntity(
    override var name: String,
    override val value: String,
    override val description: String?
) : UiCardMachineDetailsItemEntity()

data class UiTerminalIdEntity(
    override var name: String,
    override val value: String,
    override val description: String?
) : UiCardMachineDetailsItemEntity() {

}