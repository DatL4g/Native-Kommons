package dev.datlag.kommons


data object PapuaNewGuinea : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("PG")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("PNG")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(598)
}