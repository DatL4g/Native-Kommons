package dev.datlag.kommons


data object Romania : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("RO")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("ROU")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(642)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(40)
}