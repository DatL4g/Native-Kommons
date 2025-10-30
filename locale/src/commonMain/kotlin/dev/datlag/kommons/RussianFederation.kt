package dev.datlag.kommons


data object RussianFederation : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("RU")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("RUS")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(643)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(7)
}